/**
 */
package org.sheepy.lily.vulkan.model.resource.impl;

import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.sheepy.lily.core.api.adapter.LilyEObject;
import org.sheepy.lily.vulkan.model.resource.BufferDataProvider;
import org.sheepy.lily.vulkan.model.resource.ResourcePackage;

import org.sheepy.vulkan.model.enumeration.EAccess;
import org.sheepy.vulkan.model.enumeration.EBufferUsage;
import org.sheepy.vulkan.model.enumeration.EPipelineStage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Buffer Data Provider</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.impl.BufferDataProviderImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.impl.BufferDataProviderImpl#getUsage <em>Usage</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.impl.BufferDataProviderImpl#getInstanceCount <em>Instance Count</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.impl.BufferDataProviderImpl#getDataSource <em>Data Source</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.impl.BufferDataProviderImpl#isUsedToPush <em>Used To Push</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.impl.BufferDataProviderImpl#isUsedToFetch <em>Used To Fetch</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.impl.BufferDataProviderImpl#getStageBeforePush <em>Stage Before Push</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.impl.BufferDataProviderImpl#getAccessBeforePush <em>Access Before Push</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.impl.BufferDataProviderImpl#getStageBeforeFetch <em>Stage Before Fetch</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.impl.BufferDataProviderImpl#getAccessBeforeFetch <em>Access Before Fetch</em>}</li>
 * </ul>
 *
 * @generated
 */
public class BufferDataProviderImpl<T> extends LilyEObject implements BufferDataProvider<T>
{
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getUsage() <em>Usage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUsage()
	 * @generated
	 * @ordered
	 */
	protected static final EBufferUsage USAGE_EDEFAULT = EBufferUsage.TRANSFER_SRC_BIT;

	/**
	 * The cached value of the '{@link #getUsage() <em>Usage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUsage()
	 * @generated
	 * @ordered
	 */
	protected EBufferUsage usage = USAGE_EDEFAULT;

	/**
	 * The default value of the '{@link #getInstanceCount() <em>Instance Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInstanceCount()
	 * @generated
	 * @ordered
	 */
	protected static final int INSTANCE_COUNT_EDEFAULT = 1;

	/**
	 * The cached value of the '{@link #getInstanceCount() <em>Instance Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInstanceCount()
	 * @generated
	 * @ordered
	 */
	protected int instanceCount = INSTANCE_COUNT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getDataSource() <em>Data Source</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDataSource()
	 * @generated
	 * @ordered
	 */
	protected T dataSource;

	/**
	 * The default value of the '{@link #isUsedToPush() <em>Used To Push</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isUsedToPush()
	 * @generated
	 * @ordered
	 */
	protected static final boolean USED_TO_PUSH_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isUsedToPush() <em>Used To Push</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isUsedToPush()
	 * @generated
	 * @ordered
	 */
	protected boolean usedToPush = USED_TO_PUSH_EDEFAULT;

	/**
	 * The default value of the '{@link #isUsedToFetch() <em>Used To Fetch</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isUsedToFetch()
	 * @generated
	 * @ordered
	 */
	protected static final boolean USED_TO_FETCH_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isUsedToFetch() <em>Used To Fetch</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isUsedToFetch()
	 * @generated
	 * @ordered
	 */
	protected boolean usedToFetch = USED_TO_FETCH_EDEFAULT;

	/**
	 * The default value of the '{@link #getStageBeforePush() <em>Stage Before Push</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStageBeforePush()
	 * @generated
	 * @ordered
	 */
	protected static final EPipelineStage STAGE_BEFORE_PUSH_EDEFAULT = EPipelineStage.TOP_OF_PIPE_BIT;

	/**
	 * The cached value of the '{@link #getStageBeforePush() <em>Stage Before Push</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStageBeforePush()
	 * @generated
	 * @ordered
	 */
	protected EPipelineStage stageBeforePush = STAGE_BEFORE_PUSH_EDEFAULT;

	/**
	 * The cached value of the '{@link #getAccessBeforePush() <em>Access Before Push</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAccessBeforePush()
	 * @generated
	 * @ordered
	 */
	protected EList<EAccess> accessBeforePush;

	/**
	 * The default value of the '{@link #getStageBeforeFetch() <em>Stage Before Fetch</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStageBeforeFetch()
	 * @generated
	 * @ordered
	 */
	protected static final EPipelineStage STAGE_BEFORE_FETCH_EDEFAULT = EPipelineStage.TOP_OF_PIPE_BIT;

	/**
	 * The cached value of the '{@link #getStageBeforeFetch() <em>Stage Before Fetch</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStageBeforeFetch()
	 * @generated
	 * @ordered
	 */
	protected EPipelineStage stageBeforeFetch = STAGE_BEFORE_FETCH_EDEFAULT;

	/**
	 * The cached value of the '{@link #getAccessBeforeFetch() <em>Access Before Fetch</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAccessBeforeFetch()
	 * @generated
	 * @ordered
	 */
	protected EList<EAccess> accessBeforeFetch;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BufferDataProviderImpl()
	{
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass()
	{
		return ResourcePackage.Literals.BUFFER_DATA_PROVIDER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getName()
	{
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setName(String newName)
	{
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ResourcePackage.BUFFER_DATA_PROVIDER__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EBufferUsage getUsage()
	{
		return usage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setUsage(EBufferUsage newUsage)
	{
		EBufferUsage oldUsage = usage;
		usage = newUsage == null ? USAGE_EDEFAULT : newUsage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ResourcePackage.BUFFER_DATA_PROVIDER__USAGE, oldUsage, usage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getInstanceCount()
	{
		return instanceCount;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setInstanceCount(int newInstanceCount)
	{
		int oldInstanceCount = instanceCount;
		instanceCount = newInstanceCount;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ResourcePackage.BUFFER_DATA_PROVIDER__INSTANCE_COUNT, oldInstanceCount, instanceCount));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public T getDataSource()
	{
		return dataSource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDataSource(T newDataSource, NotificationChain msgs)
	{
		T oldDataSource = dataSource;
		dataSource = newDataSource;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ResourcePackage.BUFFER_DATA_PROVIDER__DATA_SOURCE, oldDataSource, newDataSource);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDataSource(T newDataSource)
	{
		if (newDataSource != dataSource)
		{
			NotificationChain msgs = null;
			if (dataSource != null)
				msgs = ((InternalEObject)dataSource).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ResourcePackage.BUFFER_DATA_PROVIDER__DATA_SOURCE, null, msgs);
			if (newDataSource != null)
				msgs = ((InternalEObject)newDataSource).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ResourcePackage.BUFFER_DATA_PROVIDER__DATA_SOURCE, null, msgs);
			msgs = basicSetDataSource(newDataSource, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ResourcePackage.BUFFER_DATA_PROVIDER__DATA_SOURCE, newDataSource, newDataSource));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isUsedToPush()
	{
		return usedToPush;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setUsedToPush(boolean newUsedToPush)
	{
		boolean oldUsedToPush = usedToPush;
		usedToPush = newUsedToPush;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ResourcePackage.BUFFER_DATA_PROVIDER__USED_TO_PUSH, oldUsedToPush, usedToPush));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isUsedToFetch()
	{
		return usedToFetch;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setUsedToFetch(boolean newUsedToFetch)
	{
		boolean oldUsedToFetch = usedToFetch;
		usedToFetch = newUsedToFetch;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ResourcePackage.BUFFER_DATA_PROVIDER__USED_TO_FETCH, oldUsedToFetch, usedToFetch));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EPipelineStage getStageBeforePush()
	{
		return stageBeforePush;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setStageBeforePush(EPipelineStage newStageBeforePush)
	{
		EPipelineStage oldStageBeforePush = stageBeforePush;
		stageBeforePush = newStageBeforePush == null ? STAGE_BEFORE_PUSH_EDEFAULT : newStageBeforePush;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ResourcePackage.BUFFER_DATA_PROVIDER__STAGE_BEFORE_PUSH, oldStageBeforePush, stageBeforePush));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<EAccess> getAccessBeforePush()
	{
		if (accessBeforePush == null)
		{
			accessBeforePush = new EDataTypeUniqueEList<EAccess>(EAccess.class, this, ResourcePackage.BUFFER_DATA_PROVIDER__ACCESS_BEFORE_PUSH);
		}
		return accessBeforePush;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EPipelineStage getStageBeforeFetch()
	{
		return stageBeforeFetch;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setStageBeforeFetch(EPipelineStage newStageBeforeFetch)
	{
		EPipelineStage oldStageBeforeFetch = stageBeforeFetch;
		stageBeforeFetch = newStageBeforeFetch == null ? STAGE_BEFORE_FETCH_EDEFAULT : newStageBeforeFetch;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ResourcePackage.BUFFER_DATA_PROVIDER__STAGE_BEFORE_FETCH, oldStageBeforeFetch, stageBeforeFetch));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<EAccess> getAccessBeforeFetch()
	{
		if (accessBeforeFetch == null)
		{
			accessBeforeFetch = new EDataTypeUniqueEList<EAccess>(EAccess.class, this, ResourcePackage.BUFFER_DATA_PROVIDER__ACCESS_BEFORE_FETCH);
		}
		return accessBeforeFetch;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
	{
		switch (featureID)
		{
			case ResourcePackage.BUFFER_DATA_PROVIDER__DATA_SOURCE:
				return basicSetDataSource(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType)
	{
		switch (featureID)
		{
			case ResourcePackage.BUFFER_DATA_PROVIDER__NAME:
				return getName();
			case ResourcePackage.BUFFER_DATA_PROVIDER__USAGE:
				return getUsage();
			case ResourcePackage.BUFFER_DATA_PROVIDER__INSTANCE_COUNT:
				return getInstanceCount();
			case ResourcePackage.BUFFER_DATA_PROVIDER__DATA_SOURCE:
				return getDataSource();
			case ResourcePackage.BUFFER_DATA_PROVIDER__USED_TO_PUSH:
				return isUsedToPush();
			case ResourcePackage.BUFFER_DATA_PROVIDER__USED_TO_FETCH:
				return isUsedToFetch();
			case ResourcePackage.BUFFER_DATA_PROVIDER__STAGE_BEFORE_PUSH:
				return getStageBeforePush();
			case ResourcePackage.BUFFER_DATA_PROVIDER__ACCESS_BEFORE_PUSH:
				return getAccessBeforePush();
			case ResourcePackage.BUFFER_DATA_PROVIDER__STAGE_BEFORE_FETCH:
				return getStageBeforeFetch();
			case ResourcePackage.BUFFER_DATA_PROVIDER__ACCESS_BEFORE_FETCH:
				return getAccessBeforeFetch();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue)
	{
		switch (featureID)
		{
			case ResourcePackage.BUFFER_DATA_PROVIDER__NAME:
				setName((String)newValue);
				return;
			case ResourcePackage.BUFFER_DATA_PROVIDER__USAGE:
				setUsage((EBufferUsage)newValue);
				return;
			case ResourcePackage.BUFFER_DATA_PROVIDER__INSTANCE_COUNT:
				setInstanceCount((Integer)newValue);
				return;
			case ResourcePackage.BUFFER_DATA_PROVIDER__DATA_SOURCE:
				setDataSource((T)newValue);
				return;
			case ResourcePackage.BUFFER_DATA_PROVIDER__USED_TO_PUSH:
				setUsedToPush((Boolean)newValue);
				return;
			case ResourcePackage.BUFFER_DATA_PROVIDER__USED_TO_FETCH:
				setUsedToFetch((Boolean)newValue);
				return;
			case ResourcePackage.BUFFER_DATA_PROVIDER__STAGE_BEFORE_PUSH:
				setStageBeforePush((EPipelineStage)newValue);
				return;
			case ResourcePackage.BUFFER_DATA_PROVIDER__ACCESS_BEFORE_PUSH:
				getAccessBeforePush().clear();
				getAccessBeforePush().addAll((Collection<? extends EAccess>)newValue);
				return;
			case ResourcePackage.BUFFER_DATA_PROVIDER__STAGE_BEFORE_FETCH:
				setStageBeforeFetch((EPipelineStage)newValue);
				return;
			case ResourcePackage.BUFFER_DATA_PROVIDER__ACCESS_BEFORE_FETCH:
				getAccessBeforeFetch().clear();
				getAccessBeforeFetch().addAll((Collection<? extends EAccess>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID)
	{
		switch (featureID)
		{
			case ResourcePackage.BUFFER_DATA_PROVIDER__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ResourcePackage.BUFFER_DATA_PROVIDER__USAGE:
				setUsage(USAGE_EDEFAULT);
				return;
			case ResourcePackage.BUFFER_DATA_PROVIDER__INSTANCE_COUNT:
				setInstanceCount(INSTANCE_COUNT_EDEFAULT);
				return;
			case ResourcePackage.BUFFER_DATA_PROVIDER__DATA_SOURCE:
				setDataSource((T)null);
				return;
			case ResourcePackage.BUFFER_DATA_PROVIDER__USED_TO_PUSH:
				setUsedToPush(USED_TO_PUSH_EDEFAULT);
				return;
			case ResourcePackage.BUFFER_DATA_PROVIDER__USED_TO_FETCH:
				setUsedToFetch(USED_TO_FETCH_EDEFAULT);
				return;
			case ResourcePackage.BUFFER_DATA_PROVIDER__STAGE_BEFORE_PUSH:
				setStageBeforePush(STAGE_BEFORE_PUSH_EDEFAULT);
				return;
			case ResourcePackage.BUFFER_DATA_PROVIDER__ACCESS_BEFORE_PUSH:
				getAccessBeforePush().clear();
				return;
			case ResourcePackage.BUFFER_DATA_PROVIDER__STAGE_BEFORE_FETCH:
				setStageBeforeFetch(STAGE_BEFORE_FETCH_EDEFAULT);
				return;
			case ResourcePackage.BUFFER_DATA_PROVIDER__ACCESS_BEFORE_FETCH:
				getAccessBeforeFetch().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID)
	{
		switch (featureID)
		{
			case ResourcePackage.BUFFER_DATA_PROVIDER__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ResourcePackage.BUFFER_DATA_PROVIDER__USAGE:
				return usage != USAGE_EDEFAULT;
			case ResourcePackage.BUFFER_DATA_PROVIDER__INSTANCE_COUNT:
				return instanceCount != INSTANCE_COUNT_EDEFAULT;
			case ResourcePackage.BUFFER_DATA_PROVIDER__DATA_SOURCE:
				return dataSource != null;
			case ResourcePackage.BUFFER_DATA_PROVIDER__USED_TO_PUSH:
				return usedToPush != USED_TO_PUSH_EDEFAULT;
			case ResourcePackage.BUFFER_DATA_PROVIDER__USED_TO_FETCH:
				return usedToFetch != USED_TO_FETCH_EDEFAULT;
			case ResourcePackage.BUFFER_DATA_PROVIDER__STAGE_BEFORE_PUSH:
				return stageBeforePush != STAGE_BEFORE_PUSH_EDEFAULT;
			case ResourcePackage.BUFFER_DATA_PROVIDER__ACCESS_BEFORE_PUSH:
				return accessBeforePush != null && !accessBeforePush.isEmpty();
			case ResourcePackage.BUFFER_DATA_PROVIDER__STAGE_BEFORE_FETCH:
				return stageBeforeFetch != STAGE_BEFORE_FETCH_EDEFAULT;
			case ResourcePackage.BUFFER_DATA_PROVIDER__ACCESS_BEFORE_FETCH:
				return accessBeforeFetch != null && !accessBeforeFetch.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString()
	{
		if (eIsProxy()) return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(", usage: ");
		result.append(usage);
		result.append(", instanceCount: ");
		result.append(instanceCount);
		result.append(", usedToPush: ");
		result.append(usedToPush);
		result.append(", usedToFetch: ");
		result.append(usedToFetch);
		result.append(", stageBeforePush: ");
		result.append(stageBeforePush);
		result.append(", accessBeforePush: ");
		result.append(accessBeforePush);
		result.append(", stageBeforeFetch: ");
		result.append(stageBeforeFetch);
		result.append(", accessBeforeFetch: ");
		result.append(accessBeforeFetch);
		result.append(')');
		return result.toString();
	}

} //BufferDataProviderImpl

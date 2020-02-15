/**
 */
package org.sheepy.lily.vulkan.model.resource.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;

import org.sheepy.lily.core.api.adapter.LilyEObject;

import org.sheepy.lily.vulkan.model.resource.BufferDataProvider;
import org.sheepy.lily.vulkan.model.resource.VulkanResourcePackage;

import org.sheepy.vulkan.model.enumeration.EAccess;
import org.sheepy.vulkan.model.enumeration.EBufferUsage;
import org.sheepy.vulkan.model.enumeration.EInstanceCount;
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
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.impl.BufferDataProviderImpl#isUsedToPush <em>Used To Push</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.impl.BufferDataProviderImpl#isUsedToFetch <em>Used To Fetch</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.impl.BufferDataProviderImpl#getStageBeforePush <em>Stage Before Push</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.impl.BufferDataProviderImpl#getAccessBeforePush <em>Access Before Push</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.impl.BufferDataProviderImpl#getStageBeforeFetch <em>Stage Before Fetch</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.impl.BufferDataProviderImpl#getAccessBeforeFetch <em>Access Before Fetch</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.impl.BufferDataProviderImpl#getUsages <em>Usages</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.impl.BufferDataProviderImpl#getInstanceCount <em>Instance Count</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.impl.BufferDataProviderImpl#getGrowFactor <em>Grow Factor</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.impl.BufferDataProviderImpl#getGrowThreshold <em>Grow Threshold</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.impl.BufferDataProviderImpl#getMinSize <em>Min Size</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.impl.BufferDataProviderImpl#getRequestedSize <em>Requested Size</em>}</li>
 * </ul>
 *
 * @generated
 */
public class BufferDataProviderImpl extends LilyEObject implements BufferDataProvider
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
	 * The cached value of the '{@link #getUsages() <em>Usages</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUsages()
	 * @generated
	 * @ordered
	 */
	protected EList<EBufferUsage> usages;

	/**
	 * The default value of the '{@link #getInstanceCount() <em>Instance Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInstanceCount()
	 * @generated
	 * @ordered
	 */
	protected static final EInstanceCount INSTANCE_COUNT_EDEFAULT = EInstanceCount.ONE;

	/**
	 * The cached value of the '{@link #getInstanceCount() <em>Instance Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInstanceCount()
	 * @generated
	 * @ordered
	 */
	protected EInstanceCount instanceCount = INSTANCE_COUNT_EDEFAULT;

	/**
	 * The default value of the '{@link #getGrowFactor() <em>Grow Factor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGrowFactor()
	 * @generated
	 * @ordered
	 */
	protected static final float GROW_FACTOR_EDEFAULT = 1.0F;

	/**
	 * The cached value of the '{@link #getGrowFactor() <em>Grow Factor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGrowFactor()
	 * @generated
	 * @ordered
	 */
	protected float growFactor = GROW_FACTOR_EDEFAULT;

	/**
	 * The default value of the '{@link #getGrowThreshold() <em>Grow Threshold</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGrowThreshold()
	 * @generated
	 * @ordered
	 */
	protected static final float GROW_THRESHOLD_EDEFAULT = 1.0F;

	/**
	 * The cached value of the '{@link #getGrowThreshold() <em>Grow Threshold</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGrowThreshold()
	 * @generated
	 * @ordered
	 */
	protected float growThreshold = GROW_THRESHOLD_EDEFAULT;

	/**
	 * The default value of the '{@link #getMinSize() <em>Min Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMinSize()
	 * @generated
	 * @ordered
	 */
	protected static final long MIN_SIZE_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getMinSize() <em>Min Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMinSize()
	 * @generated
	 * @ordered
	 */
	protected long minSize = MIN_SIZE_EDEFAULT;

	/**
	 * The default value of the '{@link #getRequestedSize() <em>Requested Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRequestedSize()
	 * @generated
	 * @ordered
	 */
	protected static final long REQUESTED_SIZE_EDEFAULT = 1L;

	/**
	 * The cached value of the '{@link #getRequestedSize() <em>Requested Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRequestedSize()
	 * @generated
	 * @ordered
	 */
	protected long requestedSize = REQUESTED_SIZE_EDEFAULT;

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
		return VulkanResourcePackage.Literals.BUFFER_DATA_PROVIDER;
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
			eNotify(new ENotificationImpl(this, Notification.SET, VulkanResourcePackage.BUFFER_DATA_PROVIDER__NAME, oldName, name));
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
			eNotify(new ENotificationImpl(this, Notification.SET, VulkanResourcePackage.BUFFER_DATA_PROVIDER__USED_TO_PUSH, oldUsedToPush, usedToPush));
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
			eNotify(new ENotificationImpl(this, Notification.SET, VulkanResourcePackage.BUFFER_DATA_PROVIDER__USED_TO_FETCH, oldUsedToFetch, usedToFetch));
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
			eNotify(new ENotificationImpl(this, Notification.SET, VulkanResourcePackage.BUFFER_DATA_PROVIDER__STAGE_BEFORE_PUSH, oldStageBeforePush, stageBeforePush));
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
			accessBeforePush = new EDataTypeUniqueEList<EAccess>(EAccess.class, this, VulkanResourcePackage.BUFFER_DATA_PROVIDER__ACCESS_BEFORE_PUSH);
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
			eNotify(new ENotificationImpl(this, Notification.SET, VulkanResourcePackage.BUFFER_DATA_PROVIDER__STAGE_BEFORE_FETCH, oldStageBeforeFetch, stageBeforeFetch));
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
			accessBeforeFetch = new EDataTypeUniqueEList<EAccess>(EAccess.class, this, VulkanResourcePackage.BUFFER_DATA_PROVIDER__ACCESS_BEFORE_FETCH);
		}
		return accessBeforeFetch;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<EBufferUsage> getUsages()
	{
		if (usages == null)
		{
			usages = new EDataTypeUniqueEList<EBufferUsage>(EBufferUsage.class, this, VulkanResourcePackage.BUFFER_DATA_PROVIDER__USAGES);
		}
		return usages;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EInstanceCount getInstanceCount()
	{
		return instanceCount;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setInstanceCount(EInstanceCount newInstanceCount)
	{
		EInstanceCount oldInstanceCount = instanceCount;
		instanceCount = newInstanceCount == null ? INSTANCE_COUNT_EDEFAULT : newInstanceCount;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VulkanResourcePackage.BUFFER_DATA_PROVIDER__INSTANCE_COUNT, oldInstanceCount, instanceCount));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public float getGrowFactor()
	{
		return growFactor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setGrowFactor(float newGrowFactor)
	{
		float oldGrowFactor = growFactor;
		growFactor = newGrowFactor;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VulkanResourcePackage.BUFFER_DATA_PROVIDER__GROW_FACTOR, oldGrowFactor, growFactor));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public float getGrowThreshold()
	{
		return growThreshold;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setGrowThreshold(float newGrowThreshold)
	{
		float oldGrowThreshold = growThreshold;
		growThreshold = newGrowThreshold;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VulkanResourcePackage.BUFFER_DATA_PROVIDER__GROW_THRESHOLD, oldGrowThreshold, growThreshold));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public long getMinSize()
	{
		return minSize;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMinSize(long newMinSize)
	{
		long oldMinSize = minSize;
		minSize = newMinSize;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VulkanResourcePackage.BUFFER_DATA_PROVIDER__MIN_SIZE, oldMinSize, minSize));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public long getRequestedSize()
	{
		return requestedSize;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRequestedSize(long newRequestedSize)
	{
		long oldRequestedSize = requestedSize;
		requestedSize = newRequestedSize;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VulkanResourcePackage.BUFFER_DATA_PROVIDER__REQUESTED_SIZE, oldRequestedSize, requestedSize));
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
			case VulkanResourcePackage.BUFFER_DATA_PROVIDER__NAME:
				return getName();
			case VulkanResourcePackage.BUFFER_DATA_PROVIDER__USED_TO_PUSH:
				return isUsedToPush();
			case VulkanResourcePackage.BUFFER_DATA_PROVIDER__USED_TO_FETCH:
				return isUsedToFetch();
			case VulkanResourcePackage.BUFFER_DATA_PROVIDER__STAGE_BEFORE_PUSH:
				return getStageBeforePush();
			case VulkanResourcePackage.BUFFER_DATA_PROVIDER__ACCESS_BEFORE_PUSH:
				return getAccessBeforePush();
			case VulkanResourcePackage.BUFFER_DATA_PROVIDER__STAGE_BEFORE_FETCH:
				return getStageBeforeFetch();
			case VulkanResourcePackage.BUFFER_DATA_PROVIDER__ACCESS_BEFORE_FETCH:
				return getAccessBeforeFetch();
			case VulkanResourcePackage.BUFFER_DATA_PROVIDER__USAGES:
				return getUsages();
			case VulkanResourcePackage.BUFFER_DATA_PROVIDER__INSTANCE_COUNT:
				return getInstanceCount();
			case VulkanResourcePackage.BUFFER_DATA_PROVIDER__GROW_FACTOR:
				return getGrowFactor();
			case VulkanResourcePackage.BUFFER_DATA_PROVIDER__GROW_THRESHOLD:
				return getGrowThreshold();
			case VulkanResourcePackage.BUFFER_DATA_PROVIDER__MIN_SIZE:
				return getMinSize();
			case VulkanResourcePackage.BUFFER_DATA_PROVIDER__REQUESTED_SIZE:
				return getRequestedSize();
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
			case VulkanResourcePackage.BUFFER_DATA_PROVIDER__NAME:
				setName((String)newValue);
				return;
			case VulkanResourcePackage.BUFFER_DATA_PROVIDER__USED_TO_PUSH:
				setUsedToPush((Boolean)newValue);
				return;
			case VulkanResourcePackage.BUFFER_DATA_PROVIDER__USED_TO_FETCH:
				setUsedToFetch((Boolean)newValue);
				return;
			case VulkanResourcePackage.BUFFER_DATA_PROVIDER__STAGE_BEFORE_PUSH:
				setStageBeforePush((EPipelineStage)newValue);
				return;
			case VulkanResourcePackage.BUFFER_DATA_PROVIDER__ACCESS_BEFORE_PUSH:
				getAccessBeforePush().clear();
				getAccessBeforePush().addAll((Collection<? extends EAccess>)newValue);
				return;
			case VulkanResourcePackage.BUFFER_DATA_PROVIDER__STAGE_BEFORE_FETCH:
				setStageBeforeFetch((EPipelineStage)newValue);
				return;
			case VulkanResourcePackage.BUFFER_DATA_PROVIDER__ACCESS_BEFORE_FETCH:
				getAccessBeforeFetch().clear();
				getAccessBeforeFetch().addAll((Collection<? extends EAccess>)newValue);
				return;
			case VulkanResourcePackage.BUFFER_DATA_PROVIDER__USAGES:
				getUsages().clear();
				getUsages().addAll((Collection<? extends EBufferUsage>)newValue);
				return;
			case VulkanResourcePackage.BUFFER_DATA_PROVIDER__INSTANCE_COUNT:
				setInstanceCount((EInstanceCount)newValue);
				return;
			case VulkanResourcePackage.BUFFER_DATA_PROVIDER__GROW_FACTOR:
				setGrowFactor((Float)newValue);
				return;
			case VulkanResourcePackage.BUFFER_DATA_PROVIDER__GROW_THRESHOLD:
				setGrowThreshold((Float)newValue);
				return;
			case VulkanResourcePackage.BUFFER_DATA_PROVIDER__MIN_SIZE:
				setMinSize((Long)newValue);
				return;
			case VulkanResourcePackage.BUFFER_DATA_PROVIDER__REQUESTED_SIZE:
				setRequestedSize((Long)newValue);
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
			case VulkanResourcePackage.BUFFER_DATA_PROVIDER__NAME:
				setName(NAME_EDEFAULT);
				return;
			case VulkanResourcePackage.BUFFER_DATA_PROVIDER__USED_TO_PUSH:
				setUsedToPush(USED_TO_PUSH_EDEFAULT);
				return;
			case VulkanResourcePackage.BUFFER_DATA_PROVIDER__USED_TO_FETCH:
				setUsedToFetch(USED_TO_FETCH_EDEFAULT);
				return;
			case VulkanResourcePackage.BUFFER_DATA_PROVIDER__STAGE_BEFORE_PUSH:
				setStageBeforePush(STAGE_BEFORE_PUSH_EDEFAULT);
				return;
			case VulkanResourcePackage.BUFFER_DATA_PROVIDER__ACCESS_BEFORE_PUSH:
				getAccessBeforePush().clear();
				return;
			case VulkanResourcePackage.BUFFER_DATA_PROVIDER__STAGE_BEFORE_FETCH:
				setStageBeforeFetch(STAGE_BEFORE_FETCH_EDEFAULT);
				return;
			case VulkanResourcePackage.BUFFER_DATA_PROVIDER__ACCESS_BEFORE_FETCH:
				getAccessBeforeFetch().clear();
				return;
			case VulkanResourcePackage.BUFFER_DATA_PROVIDER__USAGES:
				getUsages().clear();
				return;
			case VulkanResourcePackage.BUFFER_DATA_PROVIDER__INSTANCE_COUNT:
				setInstanceCount(INSTANCE_COUNT_EDEFAULT);
				return;
			case VulkanResourcePackage.BUFFER_DATA_PROVIDER__GROW_FACTOR:
				setGrowFactor(GROW_FACTOR_EDEFAULT);
				return;
			case VulkanResourcePackage.BUFFER_DATA_PROVIDER__GROW_THRESHOLD:
				setGrowThreshold(GROW_THRESHOLD_EDEFAULT);
				return;
			case VulkanResourcePackage.BUFFER_DATA_PROVIDER__MIN_SIZE:
				setMinSize(MIN_SIZE_EDEFAULT);
				return;
			case VulkanResourcePackage.BUFFER_DATA_PROVIDER__REQUESTED_SIZE:
				setRequestedSize(REQUESTED_SIZE_EDEFAULT);
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
			case VulkanResourcePackage.BUFFER_DATA_PROVIDER__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case VulkanResourcePackage.BUFFER_DATA_PROVIDER__USED_TO_PUSH:
				return usedToPush != USED_TO_PUSH_EDEFAULT;
			case VulkanResourcePackage.BUFFER_DATA_PROVIDER__USED_TO_FETCH:
				return usedToFetch != USED_TO_FETCH_EDEFAULT;
			case VulkanResourcePackage.BUFFER_DATA_PROVIDER__STAGE_BEFORE_PUSH:
				return stageBeforePush != STAGE_BEFORE_PUSH_EDEFAULT;
			case VulkanResourcePackage.BUFFER_DATA_PROVIDER__ACCESS_BEFORE_PUSH:
				return accessBeforePush != null && !accessBeforePush.isEmpty();
			case VulkanResourcePackage.BUFFER_DATA_PROVIDER__STAGE_BEFORE_FETCH:
				return stageBeforeFetch != STAGE_BEFORE_FETCH_EDEFAULT;
			case VulkanResourcePackage.BUFFER_DATA_PROVIDER__ACCESS_BEFORE_FETCH:
				return accessBeforeFetch != null && !accessBeforeFetch.isEmpty();
			case VulkanResourcePackage.BUFFER_DATA_PROVIDER__USAGES:
				return usages != null && !usages.isEmpty();
			case VulkanResourcePackage.BUFFER_DATA_PROVIDER__INSTANCE_COUNT:
				return instanceCount != INSTANCE_COUNT_EDEFAULT;
			case VulkanResourcePackage.BUFFER_DATA_PROVIDER__GROW_FACTOR:
				return growFactor != GROW_FACTOR_EDEFAULT;
			case VulkanResourcePackage.BUFFER_DATA_PROVIDER__GROW_THRESHOLD:
				return growThreshold != GROW_THRESHOLD_EDEFAULT;
			case VulkanResourcePackage.BUFFER_DATA_PROVIDER__MIN_SIZE:
				return minSize != MIN_SIZE_EDEFAULT;
			case VulkanResourcePackage.BUFFER_DATA_PROVIDER__REQUESTED_SIZE:
				return requestedSize != REQUESTED_SIZE_EDEFAULT;
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
		result.append(", usages: ");
		result.append(usages);
		result.append(", instanceCount: ");
		result.append(instanceCount);
		result.append(", growFactor: ");
		result.append(growFactor);
		result.append(", growThreshold: ");
		result.append(growThreshold);
		result.append(", minSize: ");
		result.append(minSize);
		result.append(", requestedSize: ");
		result.append(requestedSize);
		result.append(')');
		return result.toString();
	}

} //BufferDataProviderImpl

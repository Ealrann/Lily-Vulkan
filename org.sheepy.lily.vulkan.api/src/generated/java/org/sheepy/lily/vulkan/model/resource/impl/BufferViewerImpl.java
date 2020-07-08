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

import org.sheepy.lily.core.model.resource.impl.IResourceImpl;

import org.sheepy.lily.vulkan.model.resource.BufferDataProvider;
import org.sheepy.lily.vulkan.model.resource.BufferViewer;
import org.sheepy.lily.vulkan.model.resource.VulkanResourcePackage;

import org.sheepy.vulkan.model.enumeration.EBufferUsage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Buffer Viewer</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.impl.BufferViewerImpl#getDataProvider <em>Data Provider</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.impl.BufferViewerImpl#getUsages <em>Usages</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.impl.BufferViewerImpl#getGrowFactor <em>Grow Factor</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.impl.BufferViewerImpl#getGrowThreshold <em>Grow Threshold</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.impl.BufferViewerImpl#getSize <em>Size</em>}</li>
 * </ul>
 *
 * @generated
 */
public class BufferViewerImpl extends IResourceImpl implements BufferViewer
{
	/**
	 * The cached value of the '{@link #getDataProvider() <em>Data Provider</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDataProvider()
	 * @generated
	 * @ordered
	 */
	protected BufferDataProvider dataProvider;

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
	 * The default value of the '{@link #getSize() <em>Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSize()
	 * @generated
	 * @ordered
	 */
	protected static final long SIZE_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getSize() <em>Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSize()
	 * @generated
	 * @ordered
	 */
	protected long size = SIZE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BufferViewerImpl()
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
		return VulkanResourcePackage.Literals.BUFFER_VIEWER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public BufferDataProvider getDataProvider()
	{
		return dataProvider;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDataProvider(BufferDataProvider newDataProvider, NotificationChain msgs)
	{
		BufferDataProvider oldDataProvider = dataProvider;
		dataProvider = newDataProvider;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, VulkanResourcePackage.BUFFER_VIEWER__DATA_PROVIDER, oldDataProvider, newDataProvider);
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
	public void setDataProvider(BufferDataProvider newDataProvider)
	{
		if (newDataProvider != dataProvider)
		{
			NotificationChain msgs = null;
			if (dataProvider != null)
				msgs = ((InternalEObject)dataProvider).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - VulkanResourcePackage.BUFFER_VIEWER__DATA_PROVIDER, null, msgs);
			if (newDataProvider != null)
				msgs = ((InternalEObject)newDataProvider).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - VulkanResourcePackage.BUFFER_VIEWER__DATA_PROVIDER, null, msgs);
			msgs = basicSetDataProvider(newDataProvider, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VulkanResourcePackage.BUFFER_VIEWER__DATA_PROVIDER, newDataProvider, newDataProvider));
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
			usages = new EDataTypeUniqueEList<EBufferUsage>(EBufferUsage.class, this, VulkanResourcePackage.BUFFER_VIEWER__USAGES);
		}
		return usages;
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
			eNotify(new ENotificationImpl(this, Notification.SET, VulkanResourcePackage.BUFFER_VIEWER__GROW_FACTOR, oldGrowFactor, growFactor));
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
			eNotify(new ENotificationImpl(this, Notification.SET, VulkanResourcePackage.BUFFER_VIEWER__GROW_THRESHOLD, oldGrowThreshold, growThreshold));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public long getSize()
	{
		return size;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSize(long newSize)
	{
		long oldSize = size;
		size = newSize;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VulkanResourcePackage.BUFFER_VIEWER__SIZE, oldSize, size));
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
			case VulkanResourcePackage.BUFFER_VIEWER__DATA_PROVIDER:
				return basicSetDataProvider(null, msgs);
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
			case VulkanResourcePackage.BUFFER_VIEWER__DATA_PROVIDER:
				return getDataProvider();
			case VulkanResourcePackage.BUFFER_VIEWER__USAGES:
				return getUsages();
			case VulkanResourcePackage.BUFFER_VIEWER__GROW_FACTOR:
				return getGrowFactor();
			case VulkanResourcePackage.BUFFER_VIEWER__GROW_THRESHOLD:
				return getGrowThreshold();
			case VulkanResourcePackage.BUFFER_VIEWER__SIZE:
				return getSize();
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
			case VulkanResourcePackage.BUFFER_VIEWER__DATA_PROVIDER:
				setDataProvider((BufferDataProvider)newValue);
				return;
			case VulkanResourcePackage.BUFFER_VIEWER__USAGES:
				getUsages().clear();
				getUsages().addAll((Collection<? extends EBufferUsage>)newValue);
				return;
			case VulkanResourcePackage.BUFFER_VIEWER__GROW_FACTOR:
				setGrowFactor((Float)newValue);
				return;
			case VulkanResourcePackage.BUFFER_VIEWER__GROW_THRESHOLD:
				setGrowThreshold((Float)newValue);
				return;
			case VulkanResourcePackage.BUFFER_VIEWER__SIZE:
				setSize((Long)newValue);
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
			case VulkanResourcePackage.BUFFER_VIEWER__DATA_PROVIDER:
				setDataProvider((BufferDataProvider)null);
				return;
			case VulkanResourcePackage.BUFFER_VIEWER__USAGES:
				getUsages().clear();
				return;
			case VulkanResourcePackage.BUFFER_VIEWER__GROW_FACTOR:
				setGrowFactor(GROW_FACTOR_EDEFAULT);
				return;
			case VulkanResourcePackage.BUFFER_VIEWER__GROW_THRESHOLD:
				setGrowThreshold(GROW_THRESHOLD_EDEFAULT);
				return;
			case VulkanResourcePackage.BUFFER_VIEWER__SIZE:
				setSize(SIZE_EDEFAULT);
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
			case VulkanResourcePackage.BUFFER_VIEWER__DATA_PROVIDER:
				return dataProvider != null;
			case VulkanResourcePackage.BUFFER_VIEWER__USAGES:
				return usages != null && !usages.isEmpty();
			case VulkanResourcePackage.BUFFER_VIEWER__GROW_FACTOR:
				return growFactor != GROW_FACTOR_EDEFAULT;
			case VulkanResourcePackage.BUFFER_VIEWER__GROW_THRESHOLD:
				return growThreshold != GROW_THRESHOLD_EDEFAULT;
			case VulkanResourcePackage.BUFFER_VIEWER__SIZE:
				return size != SIZE_EDEFAULT;
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
		result.append(" (usages: ");
		result.append(usages);
		result.append(", growFactor: ");
		result.append(growFactor);
		result.append(", growThreshold: ");
		result.append(growThreshold);
		result.append(", size: ");
		result.append(size);
		result.append(')');
		return result.toString();
	}

} //BufferViewerImpl

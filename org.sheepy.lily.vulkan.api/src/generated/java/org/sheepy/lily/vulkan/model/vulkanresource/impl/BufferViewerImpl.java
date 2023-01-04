/**
 */
package org.sheepy.lily.vulkan.model.vulkanresource.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.sheepy.lily.core.api.model.LilyEObject;
import org.sheepy.lily.vulkan.model.vulkanresource.BufferViewer;
import org.sheepy.lily.vulkan.model.vulkanresource.IBufferDataSource;
import org.sheepy.lily.vulkan.model.vulkanresource.VulkanResourcePackage;
import org.sheepy.vulkan.model.enumeration.EBufferUsage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Buffer Viewer</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.vulkanresource.impl.BufferViewerImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.vulkanresource.impl.BufferViewerImpl#getUsages <em>Usages</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.vulkanresource.impl.BufferViewerImpl#getGrowFactor <em>Grow Factor</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.vulkanresource.impl.BufferViewerImpl#getGrowThreshold <em>Grow Threshold</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.vulkanresource.impl.BufferViewerImpl#getSize <em>Size</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.vulkanresource.impl.BufferViewerImpl#getDataSource <em>Data Source</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.vulkanresource.impl.BufferViewerImpl#getDataSourceIdentifier <em>Data Source Identifier</em>}</li>
 * </ul>
 *
 * @generated
 */
public class BufferViewerImpl extends LilyEObject implements BufferViewer
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
	 * The cached value of the '{@link #getDataSource() <em>Data Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDataSource()
	 * @generated
	 * @ordered
	 */
	protected IBufferDataSource dataSource;

	/**
	 * The default value of the '{@link #getDataSourceIdentifier() <em>Data Source Identifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDataSourceIdentifier()
	 * @generated
	 * @ordered
	 */
	protected static final String DATA_SOURCE_IDENTIFIER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDataSourceIdentifier() <em>Data Source Identifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDataSourceIdentifier()
	 * @generated
	 * @ordered
	 */
	protected String dataSourceIdentifier = DATA_SOURCE_IDENTIFIER_EDEFAULT;

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
			eNotify(new ENotificationImpl(this, Notification.SET, VulkanResourcePackage.BUFFER_VIEWER__NAME, oldName, name));
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
			usages = new EDataTypeUniqueEList<>(EBufferUsage.class, this, VulkanResourcePackage.BUFFER_VIEWER__USAGES);
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
	public IBufferDataSource getDataSource()
	{
		if (dataSource != null && ((EObject)dataSource).eIsProxy())
		{
			InternalEObject oldDataSource = dataSource;
			dataSource = (IBufferDataSource)eResolveProxy(oldDataSource);
			if (dataSource != oldDataSource)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, VulkanResourcePackage.BUFFER_VIEWER__DATA_SOURCE, oldDataSource, dataSource));
			}
		}
		return dataSource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IBufferDataSource basicGetDataSource()
	{
		return dataSource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDataSource(IBufferDataSource newDataSource)
	{
		IBufferDataSource oldDataSource = dataSource;
		dataSource = newDataSource;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VulkanResourcePackage.BUFFER_VIEWER__DATA_SOURCE, oldDataSource, dataSource));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getDataSourceIdentifier()
	{
		return dataSourceIdentifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDataSourceIdentifier(String newDataSourceIdentifier)
	{
		String oldDataSourceIdentifier = dataSourceIdentifier;
		dataSourceIdentifier = newDataSourceIdentifier;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VulkanResourcePackage.BUFFER_VIEWER__DATA_SOURCE_IDENTIFIER, oldDataSourceIdentifier, dataSourceIdentifier));
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
			case VulkanResourcePackage.BUFFER_VIEWER__NAME:
				return getName();
			case VulkanResourcePackage.BUFFER_VIEWER__USAGES:
				return getUsages();
			case VulkanResourcePackage.BUFFER_VIEWER__GROW_FACTOR:
				return getGrowFactor();
			case VulkanResourcePackage.BUFFER_VIEWER__GROW_THRESHOLD:
				return getGrowThreshold();
			case VulkanResourcePackage.BUFFER_VIEWER__SIZE:
				return getSize();
			case VulkanResourcePackage.BUFFER_VIEWER__DATA_SOURCE:
				if (resolve) return getDataSource();
				return basicGetDataSource();
			case VulkanResourcePackage.BUFFER_VIEWER__DATA_SOURCE_IDENTIFIER:
				return getDataSourceIdentifier();
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
			case VulkanResourcePackage.BUFFER_VIEWER__NAME:
				setName((String)newValue);
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
			case VulkanResourcePackage.BUFFER_VIEWER__DATA_SOURCE:
				setDataSource((IBufferDataSource)newValue);
				return;
			case VulkanResourcePackage.BUFFER_VIEWER__DATA_SOURCE_IDENTIFIER:
				setDataSourceIdentifier((String)newValue);
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
			case VulkanResourcePackage.BUFFER_VIEWER__NAME:
				setName(NAME_EDEFAULT);
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
			case VulkanResourcePackage.BUFFER_VIEWER__DATA_SOURCE:
				setDataSource((IBufferDataSource)null);
				return;
			case VulkanResourcePackage.BUFFER_VIEWER__DATA_SOURCE_IDENTIFIER:
				setDataSourceIdentifier(DATA_SOURCE_IDENTIFIER_EDEFAULT);
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
			case VulkanResourcePackage.BUFFER_VIEWER__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case VulkanResourcePackage.BUFFER_VIEWER__USAGES:
				return usages != null && !usages.isEmpty();
			case VulkanResourcePackage.BUFFER_VIEWER__GROW_FACTOR:
				return growFactor != GROW_FACTOR_EDEFAULT;
			case VulkanResourcePackage.BUFFER_VIEWER__GROW_THRESHOLD:
				return growThreshold != GROW_THRESHOLD_EDEFAULT;
			case VulkanResourcePackage.BUFFER_VIEWER__SIZE:
				return size != SIZE_EDEFAULT;
			case VulkanResourcePackage.BUFFER_VIEWER__DATA_SOURCE:
				return dataSource != null;
			case VulkanResourcePackage.BUFFER_VIEWER__DATA_SOURCE_IDENTIFIER:
				return DATA_SOURCE_IDENTIFIER_EDEFAULT == null ? dataSourceIdentifier != null : !DATA_SOURCE_IDENTIFIER_EDEFAULT.equals(dataSourceIdentifier);
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
		result.append(", usages: ");
		result.append(usages);
		result.append(", growFactor: ");
		result.append(growFactor);
		result.append(", growThreshold: ");
		result.append(growThreshold);
		result.append(", size: ");
		result.append(size);
		result.append(", dataSourceIdentifier: ");
		result.append(dataSourceIdentifier);
		result.append(')');
		return result.toString();
	}

} //BufferViewerImpl

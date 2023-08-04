/**
 */
package org.sheepy.lily.vulkan.extra.model.rendering.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.sheepy.lily.core.api.model.LilyEObject;
import org.sheepy.lily.core.model.types.LNamedElement;
import org.sheepy.lily.core.model.types.TypesPackage;
import org.sheepy.lily.vulkan.extra.model.rendering.RenderableDataSource;
import org.sheepy.lily.vulkan.extra.model.rendering.RenderingPackage;
import org.sheepy.lily.vulkan.extra.model.rendering.Structure;
import org.sheepy.lily.vulkan.model.IVulkanResource;
import org.sheepy.lily.vulkan.model.vulkanresource.IBufferDataSource;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Renderable Data Source</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.rendering.impl.RenderableDataSourceImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.rendering.impl.RenderableDataSourceImpl#getStructure <em>Structure</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.rendering.impl.RenderableDataSourceImpl#getPart <em>Part</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.rendering.impl.RenderableDataSourceImpl#getDataSource <em>Data Source</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RenderableDataSourceImpl<T extends Structure> extends LilyEObject implements RenderableDataSource<T>
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
	 * The cached value of the '{@link #getStructure() <em>Structure</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStructure()
	 * @generated
	 * @ordered
	 */
	protected T structure;

	/**
	 * The default value of the '{@link #getPart() <em>Part</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPart()
	 * @generated
	 * @ordered
	 */
	protected static final int PART_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getPart() <em>Part</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPart()
	 * @generated
	 * @ordered
	 */
	protected int part = PART_EDEFAULT;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RenderableDataSourceImpl()
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
		return RenderingPackage.Literals.RENDERABLE_DATA_SOURCE;
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
			eNotify(new ENotificationImpl(this, Notification.SET, RenderingPackage.RENDERABLE_DATA_SOURCE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public T getStructure()
	{
		if (structure != null && ((EObject)structure).eIsProxy())
		{
			InternalEObject oldStructure = (InternalEObject)structure;
			structure = (T)eResolveProxy(oldStructure);
			if (structure != oldStructure)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RenderingPackage.RENDERABLE_DATA_SOURCE__STRUCTURE, oldStructure, structure));
			}
		}
		return structure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public T basicGetStructure()
	{
		return structure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setStructure(T newStructure)
	{
		T oldStructure = structure;
		structure = newStructure;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RenderingPackage.RENDERABLE_DATA_SOURCE__STRUCTURE, oldStructure, structure));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getPart()
	{
		return part;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPart(int newPart)
	{
		int oldPart = part;
		part = newPart;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RenderingPackage.RENDERABLE_DATA_SOURCE__PART, oldPart, part));
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
			InternalEObject oldDataSource = (InternalEObject)dataSource;
			dataSource = (IBufferDataSource)eResolveProxy(oldDataSource);
			if (dataSource != oldDataSource)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RenderingPackage.RENDERABLE_DATA_SOURCE__DATA_SOURCE, oldDataSource, dataSource));
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
			eNotify(new ENotificationImpl(this, Notification.SET, RenderingPackage.RENDERABLE_DATA_SOURCE__DATA_SOURCE, oldDataSource, dataSource));
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
			case RenderingPackage.RENDERABLE_DATA_SOURCE__NAME:
				return getName();
			case RenderingPackage.RENDERABLE_DATA_SOURCE__STRUCTURE:
				if (resolve) return getStructure();
				return basicGetStructure();
			case RenderingPackage.RENDERABLE_DATA_SOURCE__PART:
				return getPart();
			case RenderingPackage.RENDERABLE_DATA_SOURCE__DATA_SOURCE:
				if (resolve) return getDataSource();
				return basicGetDataSource();
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
			case RenderingPackage.RENDERABLE_DATA_SOURCE__NAME:
				setName((String)newValue);
				return;
			case RenderingPackage.RENDERABLE_DATA_SOURCE__STRUCTURE:
				setStructure((T)newValue);
				return;
			case RenderingPackage.RENDERABLE_DATA_SOURCE__PART:
				setPart((Integer)newValue);
				return;
			case RenderingPackage.RENDERABLE_DATA_SOURCE__DATA_SOURCE:
				setDataSource((IBufferDataSource)newValue);
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
			case RenderingPackage.RENDERABLE_DATA_SOURCE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case RenderingPackage.RENDERABLE_DATA_SOURCE__STRUCTURE:
				setStructure((T)null);
				return;
			case RenderingPackage.RENDERABLE_DATA_SOURCE__PART:
				setPart(PART_EDEFAULT);
				return;
			case RenderingPackage.RENDERABLE_DATA_SOURCE__DATA_SOURCE:
				setDataSource((IBufferDataSource)null);
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
			case RenderingPackage.RENDERABLE_DATA_SOURCE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case RenderingPackage.RENDERABLE_DATA_SOURCE__STRUCTURE:
				return structure != null;
			case RenderingPackage.RENDERABLE_DATA_SOURCE__PART:
				return part != PART_EDEFAULT;
			case RenderingPackage.RENDERABLE_DATA_SOURCE__DATA_SOURCE:
				return dataSource != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass)
	{
		if (baseClass == LNamedElement.class)
		{
			switch (derivedFeatureID)
			{
				case RenderingPackage.RENDERABLE_DATA_SOURCE__NAME: return TypesPackage.LNAMED_ELEMENT__NAME;
				default: return -1;
			}
		}
		if (baseClass == IVulkanResource.class)
		{
			switch (derivedFeatureID)
			{
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass)
	{
		if (baseClass == LNamedElement.class)
		{
			switch (baseFeatureID)
			{
				case TypesPackage.LNAMED_ELEMENT__NAME: return RenderingPackage.RENDERABLE_DATA_SOURCE__NAME;
				default: return -1;
			}
		}
		if (baseClass == IVulkanResource.class)
		{
			switch (baseFeatureID)
			{
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
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
		result.append(", part: ");
		result.append(part);
		result.append(')');
		return result.toString();
	}

} //RenderableDataSourceImpl

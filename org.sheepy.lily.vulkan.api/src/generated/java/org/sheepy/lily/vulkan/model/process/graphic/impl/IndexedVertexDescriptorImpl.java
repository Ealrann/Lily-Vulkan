/**
 */
package org.sheepy.lily.vulkan.model.process.graphic.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage;
import org.sheepy.lily.vulkan.model.process.graphic.IndexedVertexDescriptor;
import org.sheepy.vulkan.model.enumeration.EIndexType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Indexed Vertex Descriptor</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.impl.IndexedVertexDescriptorImpl#getIndexType <em>Index Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IndexedVertexDescriptorImpl extends VertexDescriptorImpl
		implements IndexedVertexDescriptor
{
	/**
	 * The default value of the '{@link #getIndexType() <em>Index Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIndexType()
	 * @generated
	 * @ordered
	 */
	protected static final EIndexType INDEX_TYPE_EDEFAULT = EIndexType.UINT16;

	/**
	 * The cached value of the '{@link #getIndexType() <em>Index Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIndexType()
	 * @generated
	 * @ordered
	 */
	protected EIndexType indexType = INDEX_TYPE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IndexedVertexDescriptorImpl()
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
		return GraphicPackage.Literals.INDEXED_VERTEX_DESCRIPTOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EIndexType getIndexType()
	{
		return indexType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIndexType(EIndexType newIndexType)
	{
		EIndexType oldIndexType = indexType;
		indexType = newIndexType == null ? INDEX_TYPE_EDEFAULT : newIndexType;
		if (eNotificationRequired()) eNotify(new ENotificationImpl(this, Notification.SET,
				GraphicPackage.INDEXED_VERTEX_DESCRIPTOR__INDEX_TYPE, oldIndexType, indexType));
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
		case GraphicPackage.INDEXED_VERTEX_DESCRIPTOR__INDEX_TYPE:
			return getIndexType();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue)
	{
		switch (featureID)
		{
		case GraphicPackage.INDEXED_VERTEX_DESCRIPTOR__INDEX_TYPE:
			setIndexType((EIndexType) newValue);
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
		case GraphicPackage.INDEXED_VERTEX_DESCRIPTOR__INDEX_TYPE:
			setIndexType(INDEX_TYPE_EDEFAULT);
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
		case GraphicPackage.INDEXED_VERTEX_DESCRIPTOR__INDEX_TYPE:
			return indexType != INDEX_TYPE_EDEFAULT;
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
		result.append(" (indexType: ");
		result.append(indexType);
		result.append(')');
		return result.toString();
	}

} //IndexedVertexDescriptorImpl
